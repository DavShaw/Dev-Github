
import re
from src.models.Graph.Types import *
from src.models.Graph.GraphComponents import *
from src.models.External.JsonManager import JsonGenerator
from dataclasses import dataclass, field
from src.models.Graph.Types import *
import sys

path = r'C:\Users\David\Desktop\Dev (Local)\Dev-Github\Python\Estructura de Datos\KnowledgeGraph'
sys.path.append(path)


@dataclass
class GraphGenerator:

    _data_dict: dict = field(default_factory=dict)

    _edges: list = field(default_factory=list)
    _actor_edges: list = field(default_factory=list)
    _category_edges: list = field(default_factory=list)
    _director_edges: list = field(default_factory=list)
    _language_edges: list = field(default_factory=list)
    _distributor_edges: list = field(default_factory=list)
    _platform_edges: list = field(default_factory=list)
    _genre_edges: list = field(default_factory=list)
    

    _nodes: list = field(default_factory=list)
    _movies_nodes: list = field(default_factory=list)
    _director_nodes: list = field(default_factory=list)
    _actor_nodes: list = field(default_factory=list)
    _category_nodes: list = field(default_factory=list)
    _platforms_nodes: list = field(default_factory=list)
    _genre_nodes: list = field(default_factory=list)
    _language_nodes: list = field(default_factory=list)
    _distributor_nodes: list = field(default_factory=list)

    # private methods (Methods to get, set and filter nodes)
    def _data_dict_checker(self) -> bool:
        return isinstance(self._data_dict, dict)

    def _get_dict(self) -> dict:
        return self._data_dict

    def _get_movies_url_and_name(self) -> list:

        list_of_movies_url_and_name = []

        if self._data_dict_checker():

            for id in self._data_dict:
                url = id
                name = self._data_dict[id]['name']
                list_of_movies_url_and_name.append((url, name))
        return list_of_movies_url_and_name

    def _filter_nodes(self) -> None:
        self._nodes = list(set(self._nodes))
        self._movies_nodes = list(set(self._movies_nodes))
        self._director_nodes = list(set(self._director_nodes))
        self._actor_nodes = list(set(self._actor_nodes))
        self._category_nodes = list(set(self._category_nodes))
        self._platforms_nodes = list(set(self._platforms_nodes))
        self._genre_nodes = list(set(self._genre_nodes))
        self._language_nodes = list(set(self._language_nodes))
        self._distributor_nodes = list(set(self._distributor_nodes))
        
        for node in self._nodes:
            if self._node_contains_none(node):
                self._nodes.remove(node)
        for node in self._movies_nodes:
            if self._node_contains_none(node):
                self._movies_nodes.remove(node)
        for node in self._director_nodes:
            if self._node_contains_none(node):
                self._director_nodes.remove(node)
        for node in self._actor_nodes:
            if self._node_contains_none(node):
                self._actor_nodes.remove(node)
        for node in self._category_nodes:
            if self._node_contains_none(node):
                self._category_nodes.remove(node)
        for node in self._platforms_nodes:
            if self._node_contains_none(node):
                self._platforms_nodes.remove(node)
        for node in self._genre_nodes:
            if self._node_contains_none(node):
                self._genre_nodes.remove(node)
        for node in self._language_nodes:
            if self._node_contains_none(node):
                self._language_nodes.remove(node)
        for node in self._distributor_nodes:
            if self._node_contains_none(node):
                self._distributor_nodes.remove(node)
                
    def _node_contains_none(self, node: NodeTypes) -> bool:
        
        if isinstance(node.value, tuple):
            for value in node.value:
                if isinstance(value, str) and ("(none)" in value.lower()):
                    return True
                
        elif isinstance(node.value, str) and ("(none)" in node.value.lower()):
            return True
        
        return False
        
    def _filter_category_before_parentesis(self, category) -> str:
        # Example: function("ASD (Brief Suggestive Language|Action|Sequences of Sci-Fi Violence)") -> "ASD"

        match = re.search(r'^([^()]*)', category)

        if match:
            return match.group(1).strip()
        return ""

    def _filter_category_after_parentesis(self, category) -> list:
        # Example: function("ASD (Brief Suggestive Language|Action|Sequences of Sci-Fi Violence)") -> ["Brief Suggestive Language", "Action", "Sequences of Sci-Fi Violence"]

        match = re.search(r'\(([^()]*)\)', category)

        if match:
            return match.group(1).split("|")
        return []

    def _filter_genre(self, genre) -> list:
        # Example: function("Action, Adventure, Sci-Fi") -> ["Action", "Adventure", "Sci-Fi"]
        return genre.split(", ")

    def _generate_movie_nodes(self) -> None:

        movies_url_and_name = self._get_movies_url_and_name()

        for tuple in movies_url_and_name:
            node = Node()
            node.value = tuple
            self._nodes.append(node)
            self._movies_nodes.append(node)

    def _generate_director_nodes(self) -> None:

        if self._data_dict_checker():

            for id in self._data_dict:

                director = self._data_dict[id]['director']
                node = Node()
                node.value = director
                self._nodes.append(node)
                self._director_nodes.append(node)

    def _generate_actor_nodes(self) -> None:

        if self._data_dict_checker():

            for id in self._data_dict:

                actors = self._data_dict[id]['actors']

                for actor in actors:
                    node = Node()
                    node.value = actor
                    self._nodes.append(node)
                    self._actor_nodes.append(node)

    def _generate_category_nodes(self) -> None:

        if self._data_dict_checker():

            for id in self._data_dict:

                category = self._data_dict[id]['category']

                before_parentesis = self._filter_category_before_parentesis(
                    category)
                after_parentesis = self._filter_category_after_parentesis(
                    category)

                if before_parentesis != "":
                    node = Node()
                    node.value = before_parentesis
                    self._nodes.append(node)
                    self._category_nodes.append(node)

                if after_parentesis != []:
                    for category in after_parentesis:
                        node = Node()
                        node.value = category
                        self._nodes.append(node)
                        self._category_nodes.append(node)

    def _generate_platforms_nodes(self) -> None:

        if self._data_dict_checker():

            for id in self._data_dict:

                platforms = self._data_dict[id]['platforms']

                for platform in platforms:
                    node = Node()
                    node.value = platform
                    self._nodes.append(node)
                    self._platforms_nodes.append(node)

    def _generate_genre_nodes(self) -> None:

        if self._data_dict_checker():

            for id in self._data_dict:

                genres = self._data_dict[id]['genre']
                filtered_genres = self._filter_genre(genres)

                for genre in filtered_genres:
                    node = Node()
                    node.value = genre
                    self._nodes.append(node)
                    self._genre_nodes.append(node)

    def _generate_language_nodes(self) -> None:

        if self._data_dict_checker():
            for id in self._data_dict:
                languages = self._data_dict[id]['language']
                node = Node()
                node.value = languages
                self._nodes.append(node)
                self._language_nodes.append(node)

    def _generate_distributor_nodes(self) -> None:

        if self._data_dict_checker():

            for id in self._data_dict:

                distributor = self._data_dict[id]['distributor']
                node = Node()
                node.value = distributor
                self._nodes.append(node)
                self._distributor_nodes.append(node)

    def _get_movies_nodes(self) -> list:
        self._filter_nodes()
        return self._movies_nodes

    def _get_director_nodes(self) -> list:
        self._filter_nodes()
        return self._director_nodes

    def _get_actor_nodes(self) -> list:
        self._filter_nodes()
        return self._actor_nodes

    def _get_category_nodes(self) -> list:
        self._filter_nodes()
        return self._category_nodes

    def _get_platforms_nodes(self) -> list:
        self._filter_nodes()
        return self._platforms_nodes

    def _get_genre_nodes(self) -> list:
        self._filter_nodes()
        return self._genre_nodes

    def _get_language_nodes(self) -> list:
        self._filter_nodes()
        return self._language_nodes

    def _get_distributor_nodes(self) -> list:
        self._filter_nodes()
        return self._distributor_nodes

    # private metods (Methods to get, set and filter edges)

    def _filter_edges(self) -> None:
        self._edges = list(set(self._edges))
        self._actor_edges = list(set(self._actor_edges))
        self._category_edges = list(set(self._category_edges))
        self._director_edges = list(set(self._director_edges))
        self._language_edges = list(set(self._language_edges))
        self._distributor_edges = list(set(self._distributor_edges))

    def _generate_edge_actors_to_movies(self) -> None:

        for movie in self._data_dict:
            actors = self._data_dict[movie]['actors']
            for actor in actors:

                movie_name = self._data_dict[movie]['name']

                edge = Edge(actor, movie_name, Actor())
                self._edges.append(edge)
                self._actor_edges.append(edge)

    def _generate_edge_category_to_movies(self) -> None:

        for movie in self._data_dict:
            category = self._data_dict[movie]['category']

            category1 = self._filter_category_before_parentesis(category)
            category2 = self._filter_category_after_parentesis(category)

            movie_name = self._data_dict[movie]['name']

            for element in category2:
                edge = Edge(element, movie_name, Category())
                self._edges.append(edge)
                self._category_edges.append(edge)

            edge = Edge(category1, movie_name, Category())
            self._edges.append(edge)
            self._category_edges.append(edge)

    def _generate_edge_platform_to_movies(self) -> None:

        for movie in self._data_dict:
            platforms = self._data_dict[movie]['platforms']
            movie_name = self._data_dict[movie]['name']

            for platform in platforms:
                edge = Edge(platform, movie_name, Platform())
                self._edges.append(edge)
                self._platform_edges.append(edge)

    def _generate_edge_genre_to_movies(self) -> None:

        for movie in self._data_dict:
            genres = self._data_dict[movie]['genre']
            genre = self._filter_genre(genres)
            movie_name = self._data_dict[movie]['name']

            for genre in genres:
                edge = Edge(genre, movie_name, Genre())
                self._edges.append(edge)
                self._genre_edges.append(edge)

    def _generate_edge_language_to_movies(self) -> None:

        for movie in self._data_dict:
            language = self._data_dict[movie]['language']
            movie_name = self._data_dict[movie]['name']

            edge = Edge(language, movie_name, Language())
            self._edges.append(edge)
            self._language_edges.append(edge)

    def _generate_edge_director_to_movies(self) -> None:

        for movie in self._data_dict:
            director = self._data_dict[movie]['director']
            movie_name = self._data_dict[movie]['name']

            edge = Edge(director, movie_name, Director())
            self._edges.append(edge)
            self._director_edges.append(edge)

    def _generate_edge_distributor_to_movies(self) -> None:

        for movie in self._data_dict:
            distributor = self._data_dict[movie]['distributor']
            movie_name = self._data_dict[movie]['name']

            edge = Edge(distributor, movie_name, Distributor())
            self._edges.append(edge)
            self._distributor_edges.append(edge)

    # public methods (Methods to get, set and filter nodes)

    def set_dict_from_name(self, filename) -> None:
        json_manager = JsonGenerator()
        self._data_dict = json_manager.generate_dictionary(filename)

    def get_dict(self) -> dict:
        return self._data_dict

    def generate_nodes(self) -> None:
        self._generate_movie_nodes()
        self._generate_director_nodes()
        self._generate_actor_nodes()
        self._generate_category_nodes()
        self._generate_platforms_nodes()
        self._generate_genre_nodes()
        self._generate_language_nodes()
        self._generate_distributor_nodes()
        self._filter_nodes()

    def get_nodes(self) -> list:
        self.generate_nodes()
        self._filter_nodes()
        return self._nodes

    # public methods (Methods to get, set and filter edges)

    def generate_edges(self) -> None:
        self._generate_edge_actors_to_movies()
        self._generate_edge_category_to_movies()
        self._generate_edge_platform_to_movies()
        self._generate_edge_genre_to_movies()
        self._generate_edge_language_to_movies()
        self._generate_edge_director_to_movies()
        self._generate_edge_distributor_to_movies()
        self._filter_edges()

    def get_edges(self) -> list:
        self.generate_edges()
        self._filter_edges()
        return self._edges

    def generate(self) -> None:
        self.generate_nodes()
        self._filter_nodes()
        self.generate_edges()