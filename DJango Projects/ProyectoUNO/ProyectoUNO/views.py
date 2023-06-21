from django.http import HttpResponse
from django.template import *

def home(request):
    return HttpResponse("Welcome to David's page :)")

def main(request):
    return HttpResponse("Nothing here :)")


def calc(request, n1, n2, type):
    #Checking type:
        #if type equals to +
    if type == "+":
        result = f"The result of the sum is equals to {n1+n2}"
    elif type == "-":
        result = f"The result of the rest is equals to {n1-n2}"
    elif type == "*":
        result = f"The result of the mult is equals to {n1*n2}"
    else:
        result = "None"
    return HttpResponse(result)


def math_entry(request):

    template = """
    <!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>David Math :)</title>
</head>

<body>
    <h1>
        Hi, let's make some maths UwU
    </h1>

    <input type="text" placeholder="Primer número" id="primerNumero">
    <br>
    <input type="text" placeholder="Segundo número" id="segundoNumero">
    <br>
    <input type="text" placeholder="Tipo de operacion" id="tipoOperacion">
    <br>
    <input type="submit" value="¡Cálcular!" onclick="redireccionar()">
  

  <script>
    function redireccionar()
    {
      // Obtener los valores de los campos de entrada
      var n1 = document.getElementById('primerNumero').value;
      var n2 = document.getElementById('segundoNumero').value;
      var type = document.getElementById('tipoOperacion').value;

      // Construir la URL de redirección
      var nuevaURL = `http://localhost:8000/calc/${n1}/${n2}/${type}`;
      // Redireccionar a la nueva URL
      window.location.href = nuevaURL;
    }
  </script>
</body>

</html>
    """


    return HttpResponse(template)