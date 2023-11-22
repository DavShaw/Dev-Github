# movies_data = {
# "https://rottentomatoes.com/movie_name/": {
#     'name': 'movie_name' DONE,
#     'director': "movie_directors" DONE,
#     'actors': ["movie_actors"] DONE,
#     'category': ["movie_category"] DONE,
#     'platforms': ["movie_platforms"] DONE,
#     'genre': ["movie_genders"] DONE,
#     'runtime': ["movie_runtime"] DONE,
#     'language': ["movie_language"] DONE,
#     'distributor': ["movie_distributor"] DONE,
#     'audience_score': ["movie_audience_score"] STAND BY (Doesnt working!!)
#   }
# } 



from src.models.External.JsonManager import JsonGenerator
from dataclasses import dataclass, field
from deprecated import deprecated
from bs4 import BeautifulSoup
import requests
import time
import re

@dataclass
class Scrapper:
    
    url: str = "https://www.rottentomatoes.com/browse/movies_at_home/sort:popular?page=5"
    _url_list: list = field(default_factory = list)
    _domain: str = "https://www.rottentomatoes.com"
    _soup: BeautifulSoup = None
    _has_been_connected: bool = False

    def _url_checker(self) -> None:
        if not (self.url.__contains__("https://")):
            self.url = "http://" + self.url

    def _connect_checker(self) -> None:
        self._url_checker()
        if not (self._has_been_connected):
            self.connect()

    def _get_soup(self) -> BeautifulSoup:
        self._connect_checker()
        return self._soup
    
    def _get_formated_soup(self,html) -> BeautifulSoup:
        return BeautifulSoup(html, 'lxml')

    def _reform_movies_url(self, movies_list) -> None:
        new_list = []
        for movie in movies_list:
            new_list.append(self._domain + str(movie))
        return new_list
    
    def _filter_actors_name(self, string_list) -> list:
        filtered_names = []
        for string in string_list:
            parts = string.split('\n')
            actor_name = parts[0].strip()
            filtered_names.append(actor_name)
        return filtered_names

    def _filter_platforms(self, string_list) -> list:
        for index in range(len(string_list)):
            platform = string_list[index]
            platform = platform.get('image').strip()
            string_list[index] = platform
        return string_list
    
    def _filter_movie_genre(self, string) -> str:
        cleaned_string = re.sub(r'\s*,\s*', ', ', string)
        return cleaned_string.strip()

    #- - - - - - - - - - - - - - - - - - - - - - - - - -

    def connect(self) -> None:
        self._has_been_connected = True
        self._url_checker()
        result = requests.get(self.url)
        content = result.text
        self._soup = BeautifulSoup(content, 'lxml')

    def read(self) -> None:
        self._connect_checker()
        html = self._soup.prettify()
        print(html)

    def get_movies_url(self, limit: int = 0, from_html = False, html = "") -> list:
        a_objects = None
        if (not from_html):
            self._connect_checker()
            # ChatGPT has helped me with this: I only need href if those hrefs start with /m/
            a_objects = self._soup.find_all('a', {'data-track': 'scores', 'data-qa': 'discovery-media-list-item-caption', 'href': lambda href: href and href.startswith('/m/')})

        else:
            # ChatGPT has helped me with this: I only need href if those hrefs start with /m/
            soup = self._get_formated_soup(html)
            a_objects = soup.find_all('a', {'data-track': 'scores', 'data-qa': 'discovery-media-list-item-caption', 'href': lambda href: href and href.startswith('/m/')})

        if not isinstance(limit, int) or limit <= 0:
            a_objects = [a.get("href") for a in a_objects]
        else:
            a_objects = [a.get("href") for a in a_objects[:limit]]
        self._url_list = self._reform_movies_url(a_objects)
        return self._reform_movies_url(a_objects)
    
    def get_movie_html(self, url) -> str:
        result = requests.get(url)
        content = result.text
        soup = BeautifulSoup(content, 'lxml')
        return soup.prettify()

    def get_movies_html(self, url_list) -> list:
        self._connect_checker()
        html_list = []
        for url in url_list:
            html_list.append(self.get_movie_html(url))
            time.sleep(0.5)
        return html_list

    def get_movie_name(self, html) -> str:
        soup = self._get_formated_soup(html)
        result = soup.find('h1', {'slot':'title', 'class':'title', 'data-qa':'score-panel-title'})
        if result != None:
            return result.text.strip()
        return "Name not found. (None)"
    
    def get_movie_director(self, html) -> str:
        soup = self._get_formated_soup(html)
        result = soup.find('a', {'data-qa':'movie-info-director'})
        if result != None:
            return result.text.strip()
        return "Director not found. (None)"
    
    def get_movie_actors(self, html) -> str:
        soup = self._get_formated_soup(html)
        result = soup.find_all('div', {'class':'cast-and-crew-item', 'data-qa':'cast-crew-item'})
        new_result = []
        if result != None:
            for info in result:
                new_result.append((info.text).strip())
            return self._filter_actors_name(new_result)
        return "Actors not found. (None)"
    
    def get_movie_classification(self, html) -> str:
    
        soup = self._get_formated_soup(html)
        
        result = soup.find('span', {'data-qa': 'movie-info-item-value'})
        if result != None:
            return result.text.strip()
        return "Classification not found. (None)"

    def get_movie_platformts(self, html) -> str:
        soup = self._get_formated_soup(html)
        result = soup.find_all('where-to-watch-bubble', {'slot':'bubble', 'tabindex':'-1'})
        if result != None:
            return self._filter_platforms(result)
        return "Platforms not found. (None)"

    def get_movie_info_label(self, html, label) -> str:
        soup = self._get_formated_soup(html)
        result = soup.find('ul', {'id': 'info'})

        # ChatGPT has helped me with this: I requeried the label and then I searched for the value but the original label
        # got some spaces.
        if result != None:
            label_element = result.find('b', {'class': 'info-item-label'}, text = lambda t: t and label in t.strip())

            if label_element != None:
                value_element = label_element.find_next('span', {'data-qa': 'movie-info-item-value'})

                if value_element != None:
                    return value_element.get_text(strip = True)
        return f"Label ({label}) not found. (None)"

    def get_movie_category(self, html) -> str:
        result = self.get_movie_info_label(html, "Rating:")
        if result != None:
            return result
        return "Category not found. (None)"
    
    def get_movie_genre(self, html) -> str:
        result = self.get_movie_info_label(html, "Genre:")
        if result != None:
            return self._filter_movie_genre(result)
        return "Genre not found. (None)"
    
    def get_movie_runtime(self, html) -> str:
        result = self.get_movie_info_label(html, "Runtime:")
        if result != None:
            return result
        return "Runtime not found. (None)"
    
    def get_movie_language(self, html) -> str:
        result = self.get_movie_info_label(html, "Original Language:")
        if result != None:
            return result
        return "Language not found. (None)"

    def get_movie_distributor(self, html) -> str:
        result = self.get_movie_info_label(html, "Distributor:")
        if result != None:
            return result
        return "Distributor not found. (None)"

    @deprecated(reason = "This method is not working. I will try to fix it later.")
    def get_movie_audience_score(self, html) -> str:
        soup = self._get_formated_soup(html)
        result = soup.find('div', {'class':'scores-container'})
        if result != None:
            return result.text.strip()
        return "Audience score not found. (None)"

    def get_movies_data(self, limit = 0) -> dict:
        self._connect_checker()
        movies_data = {}
        movies_url = self._url_list
        movies_html = self.get_movies_html(movies_url)

        for index in range(len(movies_url)):

            current_html = movies_html[index]
            current_url = movies_url[index]

            current_movie = {}

            name = self.get_movie_name(current_html)
            director = self.get_movie_director(current_html)
            actors = self.get_movie_actors(current_html)
            category = self.get_movie_category(current_html)
            platforms = self.get_movie_platformts(current_html)
            genre = self.get_movie_genre(current_html)
            runtime = self.get_movie_runtime(current_html)
            language = self.get_movie_language(current_html)
            distributor = self.get_movie_distributor(current_html)

            current_movie['name'] = name
            current_movie['director'] = director
            current_movie['actors'] = actors
            current_movie['category'] = category
            current_movie['platforms'] = platforms
            current_movie['genre'] = genre
            current_movie['runtime'] = runtime
            current_movie['language'] = language
            current_movie['distributor'] = distributor

            movies_data[current_url] = current_movie
    
        return movies_data

    def get_movies_data_to_json(self, dict, file_name = 'output.json') -> None:
        json_generator: JsonGenerator = JsonGenerator()
        json_generator.generate_json(dict, file_name)




