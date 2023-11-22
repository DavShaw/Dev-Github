from abc import ABC, abstractmethod


class NodeTypes(ABC):
    @abstractmethod
    def get_type(self) -> str:
        pass
    def __repr__(self) -> str:
        return str(self.get_type())

class Movie(NodeTypes):
    def get_type(self):
        return "movie"

class Director(NodeTypes):
    def get_type(self):
        return "director"

class Actor(NodeTypes):
    def get_type(self):
        return "actor"

class Category(NodeTypes):
    def get_type(self):
        return "category"

class Platform(NodeTypes):
    def get_type(self):
        return "platform"

class Genre(NodeTypes):
    def get_type(self):
        return "genre"

class Language(NodeTypes):
    def get_type(self):
        return "language"

class Distributor(NodeTypes):
    def get_type(self):
        return "distributor"

class Runtime(NodeTypes):
    def get_type(self):
        return "runtime"