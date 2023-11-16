from src.models.Scrapping.Scrapper import Scrapper
from src.models.External.Ticker import Ticker

if __name__ == '__main__':
    scrapper = Scrapper("https://www.rottentomatoes.com/browse/movies_at_home/sort:popular?page=5")
    clock = Ticker()

    clock.start()

    movies = scrapper.get_movies_data(2)

    clock.stop()
    print("Generate dictionary time")
    clock.show_result()

    clock.start()
    scrapper.get_movies_data_to_json(movies, 'testrepooooort.json')
    clock.stop()
    print("Generate json time")
    clock.show_result()
