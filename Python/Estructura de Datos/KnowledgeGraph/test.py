import time
import cv2

# Cargar el clasificador de cascada Haar para la detección de rostros
face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')

# Iniciar la captura de video desde la cámara (0 indica la cámara predeterminada)
cap = cv2.VideoCapture(0)

ancho = 450
altura = 450
cap.set(3, ancho)  # Ancho
cap.set(4, altura)  # Altura

point3 = (0, 0)  # Inicializar point3 fuera del bucle

while True:
    # Capturar un frame de la cámara
    ret, frame = cap.read()

    # Convertir el frame a escala de grises
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    
    # Detectar rostros en el frame
    faces = face_cascade.detectMultiScale(gray, scaleFactor=1.3, minNeighbors=5)

    # Dibujar un rectángulo alrededor de cada rostro detectado
    for (x, y, w, h) in faces:
        point1 = (x, y)
        point2 = (x+w, y+h)
        point3x = int((point1[0] + point2[0]) / 2)
        point3y = int((point1[1] + point2[1]) / 2)
        point3 = (point3x, point3y)
        cv2.rectangle(frame, point1, point2, (255, 0, 0), 2)

    # Dibujar círculo en el punto medio
    cv2.circle(frame, point3, 3, (0, 0, 255), 1)

    # Mostrar el frame con los rectángulos dibujados
    cv2.imshow('Espia', frame)

    # Dibujar cuatro puntos en las esquinas del frame
    top_left = (70, 70)
    bottom_right = (ancho+(70*2), altura)

    cv2.circle(frame, top_left, 5, (0, 0, 125), -1)
    cv2.circle(frame, bottom_right, 5, (0, 0, 125), -1)

    # Mostrar el frame con los rectángulos y puntos dibujados
    cv2.imshow('Espia', frame)

    # Salir del bucle cuando se presiona la tecla 'q'
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# Liberar la captura de video y cerrar la ventana
cap.release()
cv2.destroyAllWindows()
