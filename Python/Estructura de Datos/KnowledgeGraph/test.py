import cv2
import time
import os

face_cascade = cv2.CascadeClassifier(
    cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')
cap = cv2.VideoCapture(0)

weight = int(0.2 * 1920)
height = int(0.2 * 1013)
cap.set(3, weight)
cap.set(4, height)


def check_to_exit():
    return cv2.waitKey(1) in [27, 113]


def get_movenment(left_top, right_bottom, top_face, bottom_face):

    # 0 -> center
    # 1 -> up
    # -1 -> down
    # -2 -> left
    # 2 -> right

    # Simplify this conditions
    if top_face[1] < left_top[1]:
        return 1
    elif bottom_face[1] > right_bottom[1]:
        return -1
    elif top_face[0] < left_top[0]:
        return -2
    elif bottom_face[0] > right_bottom[0]:
        return 2
    return 0


while True:
    frame = cap.read()[1]
    frame = cv2.flip(frame, 1)
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    faces = face_cascade.detectMultiScale(
        gray, scaleFactor=1.3, minNeighbors=5)

    for (x, y, w, h) in faces:

        first_edge_point = (50, 30)
        secound_edge_point = (weight - 120, height - 10)

        first_point = (x, y)
        secound_point = (x + w, y + h)

        """
        
        Red point -> left top
        Blue point -> right bottom
        Green point -> top face
        Purple point -> bottom face
        
        Logic
        * if top_face(y) less than left_top(y) -> UP
        * if bottom_face(y) more than right bottom(y) -> DOWN
        """

        result = get_movenment(
            first_edge_point, secound_edge_point, first_point, secound_point)
        print(result)

        rectangle_color = (204, 238, 239)
        first_circle_color = (24, 243, 71)
        secound_circle_color = (150, 64, 222)

        cv2.rectangle(frame, first_point, secound_point,  rectangle_color, 2)

        cv2.circle(frame, first_point, 5, first_circle_color, -1)  # Green
        cv2.circle(frame, secound_point, 5, secound_circle_color, -1)  # Purple

        cv2.circle(frame, first_edge_point, 5, (0, 0, 255), -1)  # Red
        cv2.circle(frame, secound_edge_point, 5, (255, 162, 0), -1)  # Blue

    cv2.imshow('Spy cam', frame)

    if check_to_exit():
        break

cap.release()
cv2.destroyAllWindows()
