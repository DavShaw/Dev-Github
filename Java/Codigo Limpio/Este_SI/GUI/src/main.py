import requests

# Definir la URL de la API y los parámetros
url = "http://localhost:8080/davshaw/api/user/usercontroller/123456/John/Doe/Smith/Junior/mypassword"

# Realizar la solicitud POST
response = requests.post(url)

# Verificar la respuesta
if response.status_code == 200:
    print("Solicitud exitosa:")
    print(response.text)
else:
    print("Error en la solicitud. Código de estado:", response.status_code)
