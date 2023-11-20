from src.models.Scrapping.Scrapper import Scrapper
from src.models.External.Ticker import Ticker
from src.models.Graph.GraphGenerator import GraphGenerator
from src.models.External.JsonManager import JsonGenerator
if __name__ == '__main__':
    
    """
    # Hey! Execute this code if you want to recollect another data set (JSon)
        
    watcher = Ticker()
    watcher.start()
    
    global html
    html = ""
    with open('index.html', 'r', encoding = 'UTF-8') as file:
        html = file.read()
    
    hacker = Scrapper()
    urls = hacker.get_movies_url(300, True, html)
    data = hacker.get_movies_data(300)
    hacker.get_movies_data_to_json(data, 'movies_dataNo3.json')
    
    watcher.stop()
    print("Program finished in: ", end="")
    watcher.show_results()
    """
    
    graph = GraphGenerator()
    graph.set_dict_from_name('movies_dataNo3.json')
    graph.generate()
    l = graph.get_edges()
    for a in l:
        print(a)
