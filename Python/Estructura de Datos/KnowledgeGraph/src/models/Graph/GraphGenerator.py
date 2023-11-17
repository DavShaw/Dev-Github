
from src.models.Graph.Types import *
from src.models.Graph.GraphComponents import *
from src.models.External.JsonManager import JsonGenerator
from dataclasses import dataclass, field
import sys

sys.path.append(
    r'C:\Users\David\Desktop\Dev (Local)\Dev-Github\Python\Estructura de Datos\KnowledgeGraph')


@dataclass
class GraphGenerator:

    _data_dict: dict = field(default_factory = dict)
    _nodes: list = field(default_factory = list)
    _edges: list = field(default_factory = list)
    
    _movies_nodes: list = field(default_factory = list)
    _director_nodes: list = field(default_factory = list)
    _actor_nodes: list = field(default_factory = list)
    _category_nodes: list = field(default_factory = list)
    _platforms_nodes: list = field(default_factory = list)
    _genre_nodes: list = field(default_factory = list)
    _language_nodes: list = field(default_factory = list)
    _distributor_nodes: list = field(default_factory = list)
    
    def _data_dict_checker(self):
        return isinstance(self._data_dict, dict)

    def set_dict_from_name(self, filename):
        json_manager = JsonGenerator()
        self._data_dict = json_manager.generate_dictionary(filename)

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

    def generate_movie_nodes(self):

        movies_url_and_name = self._get_movies_url_and_name()

        for tuple in movies_url_and_name:
            node = Node()
            node.value = tuple
            self._nodes.append(node)
            self._movies_nodes.append(node)

    def generate_director_nodes(self):

        if self._data_dict_checker():

            for id in self._data_dict:

                director = self._data_dict[id]['director']
                node = Node()
                node.value = director
                self._nodes.append(node)
                self._director_nodes.append(node)

    def generate_actor_nodes(self):

        if self._data_dict_checker():

            for id in self._data_dict:

                actors = self._data_dict[id]['actors']

                for actor in actors:
                    node = Node()
                    node.value = actor
                    self._nodes.append(node)
                    self._actor_nodes.append(node)

    def generate_category_nodes(self):

        if self._data_dict_checker():

            for id in self._data_dict:

                category = self._data_dict[id]['category']
                node = Node()
                node.value = category
                self._nodes.append(node)
                self._category_nodes.append(node)

    def generate_platforms_nodes(self):

        if self._data_dict_checker():

            for id in self._data_dict:

                platforms = self._data_dict[id]['platforms']

                for platform in platforms:
                    node = Node()
                    node.value = platform
                    self._nodes.append(node)
                    self._platforms_nodes.append(node)

    def generate_genre_nodes(self):

        if self._data_dict_checker():

            for id in self._data_dict:

                genres = self._data_dict[id]['genre']
                node = Node()
                node.value = genres
                self._nodes.append(node)
                self._genre_nodes.append(node)

    def generate_language_nodes(self):

        if self._data_dict_checker():
            for id in self._data_dict:
                languages = self._data_dict[id]['language']
                node = Node()
                node.value = languages
                self._nodes.append(node)
                self._language_nodes.append(node)

    def generate_distributor_nodes(self):

        if self._data_dict_checker():

            for id in self._data_dict:

                distributor = self._data_dict[id]['distributor']
                node = Node()
                node.value = distributor
                self._nodes.append(node)
                self._distributor_nodes.append(node)

    def generate_nodes(self):
            self.generate_movie_nodes()
            self.generate_director_nodes()
            self.generate_actor_nodes()
            self.generate_category_nodes()
            self.generate_platforms_nodes()
            self.generate_genre_nodes()
            self.generate_language_nodes()
            self.generate_distributor_nodes()
            self._filter_nodes()

    def get_nodes(self):
        self._filter_nodes()
        return self._nodes
    
    def get_movies_nodes(self):
        self._filter_nodes()
        return self._movies_nodes

    def get_director_nodes(self):
        self._filter_nodes()
        return self._director_nodes

    def get_actor_nodes(self):
        self._filter_nodes()
        return self._actor_nodes

    def get_category_nodes(self):
        self._filter_nodes()
        return self._category_nodes

    def get_platforms_nodes(self):
        self._filter_nodes()
        return self._platforms_nodes

    def get_genre_nodes(self):
        self._filter_nodes()
        return self._genre_nodes

    def get_language_nodes(self):
        self._filter_nodes()
        return self._language_nodes

    def get_distributor_nodes(self):
        self._filter_nodes()
        return self._distributor_nodes
