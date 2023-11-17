from src.models.Scrapping.Scrapper import Scrapper
from src.models.External.Ticker import Ticker
from src.models.Graph.GraphGenerator import GraphGenerator
if __name__ == '__main__':

    graph = GraphGenerator()
    graph.set_dict_from_name("movies_dataNo1.json")
    graph.generate_nodes()
    for nodos in graph.get_movies_nodes():
        print(nodos)
    print(len(graph.get_movies_nodes()))



