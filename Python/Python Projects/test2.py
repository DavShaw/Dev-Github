import requests

url = "https://api.ip2location.io/?key={YOUR_API_KEY}&ip=2606:2e00:8027:6000::34c2"
data = requests.get(url)

print(data.status_code)