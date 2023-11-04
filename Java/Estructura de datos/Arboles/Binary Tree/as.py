import random

# Función para imprimir el tablero
def imprimir_tablero(tablero):
    for i in range(3):
        print(" | ".join(tablero[i]))
        if i < 2:
            print("-" * 9)

# Función para verificar si el juego ha terminado
def juego_terminado(tablero):
    for i in range(3):
        if tablero[i][0] == tablero[i][1] == tablero[i][2] and tablero[i][0] != ' ':
            return True
        if tablero[0][i] == tablero[1][i] == tablero[2][i] and tablero[0][i] != ' ':
            return True
    if tablero[0][0] == tablero[1][1] == tablero[2][2] and tablero[0][0] != ' ':
        return True
    if tablero[0][2] == tablero[1][1] == tablero[2][0] and tablero[0][2] != ' ':
        return True
    for i in range(3):
        for j in range(3):
            if tablero[i][j] == ' ':
                return False
    return True

# Función para evaluar el tablero
def evaluar_tablero(tablero):
    for i in range(3):
        if tablero[i][0] == tablero[i][1] == tablero[i][2] and tablero[i][0] != ' ':
            return 10 if tablero[i][0] == 'X' else -10
        if tablero[0][i] == tablero[1][i] == tablero[2][i] and tablero[0][i] != ' ':
            return 10 if tablero[0][i] == 'X' else -10
    if tablero[0][0] == tablero[1][1] == tablero[2][2] and tablero[0][0] != ' ':
        return 10 if tablero[0][0] == 'X' else -10
    if tablero[0][2] == tablero[1][1] == tablero[2][0] and tablero[0][2] != ' ':
        return 10 if tablero[0][2] == 'X' else -10
    return 0

# Función Mini-Max para encontrar el mejor movimiento
def minimax(tablero, depth, is_maximizing):
    if juego_terminado(tablero):
        return evaluar_tablero(tablero)
    
    if is_maximizing:
        max_eval = -1000
        for i in range(3):
            for j in range(3):
                if tablero[i][j] == ' ':
                    tablero[i][j] = 'X'
                    eval = minimax(tablero, depth + 1, False)
                    tablero[i][j] = ' '
                    max_eval = max(max_eval, eval)
        return max_eval
    else:
        min_eval = 1000
        for i in range(3):
            for j in range(3):
                if tablero[i][j] == ' ':
                    tablero[i][j] = 'O'
                    eval = minimax(tablero, depth + 1, True)
                    tablero[i][j] = ' '
                    min_eval = min(min_eval, eval)
        return min_eval

# Función para el movimiento del algoritmo Mini-Max
def movimiento_algoritmo(tablero):
    best_move = (-1, -1)
    best_eval = -1000
    for i in range(3):
        for j in range(3):
            if tablero[i][j] == ' ':
                tablero[i][j] = 'X'
                eval = minimax(tablero, 0, False)
                tablero[i][j] = ' '
                if eval > best_eval:
                    best_eval = eval
                    best_move = (i, j)
    tablero[best_move[0]][best_move[1]] = 'X'

# Función principal del juego
def jugar_tic_tac_toe():
    tablero = [[' ' for _ in range(3)] for _ in range(3)]
    print("Bienvenido al juego de Tic Tac Toe!")
    imprimir_tablero(tablero)
    
    while not juego_terminado(tablero):
        fila = int(input("Ingresa la fila (0, 1, 2): "))
        columna = int(input("Ingresa la columna (0, 1, 2): "))
        if tablero[fila][columna] != ' ':
            print("Esa casilla ya está ocupada. Intenta de nuevo.")
            continue
        tablero[fila][columna] = 'O'
        imprimir_tablero(tablero)
        if juego_terminado(tablero):
            break
        print("Es el turno del algoritmo Mini-Max...")
        movimiento_algoritmo(tablero)
        imprimir_tablero(tablero)

    resultado = evaluar_tablero(tablero)
    if resultado == 10:
        print("¡Has ganado!")
    elif resultado == -10:
        print("El algoritmo Mini-Max ha ganado.")
    else:
        print("Es un empate.")

if __name__ == "__main__":
    jugar_tic_tac_toe()
