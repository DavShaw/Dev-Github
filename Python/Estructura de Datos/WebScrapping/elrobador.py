from urllib.request import urlopen
from bs4 import BeautifulSoup
from urllib.parse import urljoin

def get_urls_from(url):
    html = urlopen(url).read()

    soup = BeautifulSoup(html, 'html.parser')

    links = soup.find_all('a')

    url_list = []

    for link in links:
        href = link.get('href')
        if href:
            full_url = urljoin(url, href)
            url_list.append(full_url)

    return url_list

def filter_url_just_movies(url_list):
    filtered_urls = [url for url in url_list if url.startswith("https://www.rottentomatoes.com/m/")]
    return filtered_urls

def get_movie_name(url):

    html = urlopen(url).read()

    soup = BeautifulSoup(html, 'html.parser')

    movie = soup.find('h1', {"slot":"title", "class":"title"}).getText()
    return movie

def get_movie_platform(url):
    html = urlopen(url).read()
    soup = BeautifulSoup(html, 'html.parser')
    platforms = []

    # Para buscar elementos con atributos, debes usar un diccionario
    # con el nombre del atributo y su valor.
    platform = soup.find_all('where-to-watch-bubble', {"slot": "bubble"})

    for c in platform:
        platforms.append(c.get('image'))

    return platforms



links = get_urls_from("https://www.rottentomatoes.com/browse/movies_at_home/sort:popular")
links = filter_url_just_movies(links)
print()

for url in links:
    print(get_movie_name(url), end = "")
    print(get_movie_platform(url))