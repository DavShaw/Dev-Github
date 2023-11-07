import cv2

# Carga el clasificador frontal de caras pre-entrenado
face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')

# Inicializa la captura de video desde la cámara
cap = cv2.VideoCapture(0)  # El argumento 0 representa la cámara predeterminada

while True:
    ret, frame = cap.read()  # Captura un cuadro de la cámara
    if not ret:
        break

    # Convierte el cuadro a escala de grises
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

    # Detecta caras en el cuadro
    faces = face_cascade.detectMultiScale(gray, scaleFactor=1.3, minNeighbors=5)

    # Si se detecta una cara, puedes analizar las coordenadas de la cara
    for (x, y, w, h) in faces:
        # Calcula el centro de la cara
        face_center_x = x + w // 2
        face_center_y = y + h // 2

        # Determina la posición de la cara en relación con el centro del cuadro
        height, width, _ = frame.shape
        center_x = width // 2
        center_y = height // 2

        if face_center_x < center_x:
            print("La cara se mueve hacia la izquierda")
        elif face_center_x > center_x:
            print("La cara se mueve hacia la derecha")
        else:
            print("La cara está centrada horizontalmente")

        if face_center_y < center_y:
            print("La cara se mueve hacia arriba")
        elif face_center_y > center_y:
            print("La cara se mueve hacia abajo")
        else:
            print("La cara está centrada verticalmente")

    # Muestra el cuadro con el rectángulo que rodea la cara
    for (x, y, w, h) in faces:
        cv2.rectangle(frame, (x, y), (x + w, y + h), (0, 255, 0), 2)

    # Muestra el cuadro en tiempo real
    cv2.imshow('Detección de Cara en Tiempo Real', frame)

    if cv2.waitKey(1) & 0xFF == 27:  # Presiona la tecla 'Esc' para salir
        break

# Libera la captura de video y cierra la ventana
cap.release()
cv2.destroyAllWindows()
