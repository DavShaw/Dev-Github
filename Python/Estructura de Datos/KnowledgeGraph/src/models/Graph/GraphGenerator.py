
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
    _director_edges: list = field(default_factory=list)
    _language_edges: list = field(default_factory=list)
    _distributor_edges: list = field(default_factory=list)

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
    def _data_dict_checker(self):
        return isinstance(self._data_dict, dict)

    def _get_dict(self):
        return self._data_dict

    def _get_movies_url_and_name(self):

        list_of_movies_url_and_name = []

        if self._data_dict_checker():

            for id in self._data_dict:
                url = id
                name = self._data_dict[id]['name']
                list_of_movies_url_and_name.append((url, name))
        return list_of_movies_url_and_name

    def _filter_nodes(self):
        self._nodes = list(set(self._nodes))
        self._movies_nodes = list(set(self._movies_nodes))
        self._director_nodes = list(set(self._director_nodes))
        self._actor_nodes = list(set(self._actor_nodes))
        self._category_nodes = list(set(self._category_nodes))
        self._platforms_nodes = list(set(self._platforms_nodes))
        self._genre_nodes = list(set(self._genre_nodes))
        self._language_nodes = list(set(self._language_nodes))
        self._distributor_nodes = list(set(self._distributor_nodes))

    def _filter_category_nodes_before_parentesis(self, category):
        # Example: function("ASD (Brief Suggestive Language|Action|Sequences of Sci-Fi Violence)") -> "ASD"

        match = re.search(r'^([^()]*)', category)

        if match:
            return match.group(1).strip()
        return ""

    def _filter_category_nodes_after_parentesis(self, category):
        # Example: function("ASD (Brief Suggestive Language|Action|Sequences of Sci-Fi Violence)") -> ["Brief Suggestive Language", "Action", "Sequences of Sci-Fi Violence"]

        match = re.search(r'\(([^()]*)\)', category)

        if match:
            return match.group(1).split("|")
        return []

    def _filter_genre_nodes(self, genre):
        # Example: function("Action, Adventure, Sci-Fi") -> ["Action", "Adventure", "Sci-Fi"]
        return genre.split(", ")

    def _generate_movie_nodes(self):

        movies_url_and_name = self._get_movies_url_and_name()

        for tuple in movies_url_and_name:
            node = Node()
            node.value = tuple
            self._nodes.append(node)
            self._movies_nodes.append(node)

    def _generate_director_nodes(self):

        if self._data_dict_checker():

            for id in self._data_dict:

                director = self._data_dict[id]['director']
                node = Node()
                node.value = director
                self._nodes.append(node)
                self._director_nodes.append(node)

    def _generate_actor_nodes(self):

        if self._data_dict_checker():

            for id in self._data_dict:

                actors = self._data_dict[id]['actors']

                for actor in actors:
                    node = Node()
                    node.value = actor
                    self._nodes.append(node)
                    self._actor_nodes.append(node)

    def _generate_category_nodes(self):

        if self._data_dict_checker():

            for id in self._data_dict:

                category = self._data_dict[id]['category']

                before_parentesis = self._filter_category_nodes_before_parentesis(
                    category)
                after_parentesis = self._filter_category_nodes_after_parentesis(
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

    def _generate_platforms_nodes(self):

        if self._data_dict_checker():

            for id in self._data_dict:

                platforms = self._data_dict[id]['platforms']

                for platform in platforms:
                    node = Node()
                    node.value = platform
                    self._nodes.append(node)
                    self._platforms_nodes.append(node)

    def _generate_genre_nodes(self):

        if self._data_dict_checker():

            for id in self._data_dict:

                genres = self._data_dict[id]['genre']
                filtered_genres = self._filter_genre_nodes(genres)

                for genre in filtered_genres:
                    node = Node()
                    node.value = genre
                    self._nodes.append(node)
                    self._genre_nodes.append(node)

    def _generate_language_nodes(self):

        if self._data_dict_checker():
            for id in self._data_dict:
                languages = self._data_dict[id]['language']
                node = Node()
                node.value = languages
                self._nodes.append(node)
                self._language_nodes.append(node)

    def _generate_distributor_nodes(self):

        if self._data_dict_checker():

            for id in self._data_dict:

                distributor = self._data_dict[id]['distributor']
                node = Node()
                node.value = distributor
                self._nodes.append(node)
                self._distributor_nodes.append(node)

    def _get_movies_nodes(self):
        self._filter_nodes()
        return self._movies_nodes

    def _get_director_nodes(self):
        self._filter_nodes()
        return self._director_nodes

    def _get_actor_nodes(self):
        self._filter_nodes()
        return self._actor_nodes

    def _get_category_nodes(self):
        self._filter_nodes()
        return self._category_nodes

    def _get_platforms_nodes(self):
        self._filter_nodes()
        return self._platforms_nodes

    def _get_genre_nodes(self):
        self._filter_nodes()
        return self._genre_nodes

    def _get_language_nodes(self):
        self._filter_nodes()
        return self._language_nodes

    def _get_distributor_nodes(self):
        self._filter_nodes()
        return self._distributor_nodes

    # private metods (Methods to get, set and filter edges)
    
    def _filter_edges(self):
        self._edges = list(set(self._edges))
        self._actor_edges = list(set(self._actor_edges))
        self._director_edges = list(set(self._director_edges))
        self._language_edges = list(set(self._language_edges))
    
    def _generate_edge_actors_to_movies(self):

        for movie in self._data_dict:
            actors = self._data_dict[movie]['actors']
            for actor in actors:

                movie_name = self._data_dict[movie]['name']

                edge = Edge(actor, movie_name, Actor())
                self._edges.append(edge)
                self._actor_edges.append(edge)

    def _generate_edge_language_to_movies(self):

        for movie in self._data_dict:
            language = self._data_dict[movie]['language']
            movie_name = self._data_dict[movie]['name']

            edge = Edge(language, movie_name, Language())
            self._edges.append(edge)
            self._language_edges.append(edge)

    def _generate_edge_director_to_movies(self):

        for movie in self._data_dict:
            director = self._data_dict[movie]['director']
            movie_name = self._data_dict[movie]['name']

            edge = Edge(director, movie_name, Director())
            self._edges.append(edge)
            self._director_edges.append(edge)

    def _generate_edge_distributor_to_movies(self):
        
        for movie in self._data_dict:
            distributor = self._data_dict[movie]['distributor']
            movie_name = self._data_dict[movie]['name']

            edge = Edge(distributor, movie_name, Distributor())
            self._edges.append(edge)
            self._distributor_edges.append(edge)
        
    # public methods (Methods to get, set and filter nodes)

    def set_dict_from_name(self, filename):
        json_manager = JsonGenerator()
        self._data_dict = json_manager.generate_dictionary(filename)

    def get_dict(self):
        return self._data_dict

    def generate_nodes(self):
        self._generate_movie_nodes()
        self._generate_director_nodes()
        self._generate_actor_nodes()
        self._generate_category_nodes()
        self._generate_platforms_nodes()
        self._generate_genre_nodes()
        self._generate_language_nodes()
        self._generate_distributor_nodes()
        self._filter_nodes()

    def get_nodes(self):
        self.generate_nodes()
        self._filter_nodes()
        return self._nodes

    # public methods (Methods to get, set and filter edges)
    
    def generate_edges(self):
        self._generate_edge_actors_to_movies()
        self._generate_edge_director_to_movies()
        self._generate_edge_language_to_movies()
        self._generate_distributor_nodes()
        
    def get_edges(self):
        self.generate_edges()
        self._filter_edges()
        return self._edges

    def generate(self):
        self.generate_nodes()
        self.generate_edges()


    def test(self):
        return self._distributor_edges()