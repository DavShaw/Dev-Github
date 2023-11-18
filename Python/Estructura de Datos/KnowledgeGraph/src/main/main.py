from src.models.Scrapping.Scrapper import Scrapper
from src.models.External.Ticker import Ticker
from src.models.Graph.GraphGenerator import GraphGenerator
if __name__ == '__main__':
    
    knowledgeGraph = GraphGenerator()
    knowledgeGraph.set_dict_from_name("movies_dataNo1.json")
    knowledgeGraph.generate_nodes()
    for element in knowledgeGraph.get_nodes():
        print(element.value)
    print(len(knowledgeGraph.get_nodes()))
