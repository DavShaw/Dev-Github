from dataclasses import dataclass

@dataclass
class Node:
  value:int
  next = None
  def __repr__(self):
    return f"{self.value}->"

@dataclass
class SinglyLinkedList:
  head:Node = None
  tail:Node = None

  #add_at_tail
  def add(self, value):
    if(self.head):
      self.tail.next = Node(value)
      self.tail = self.tail.next
    else:
      new_node = Node(value)
      self.head = new_node
      self.tail = new_node

  def traverse(self, current=None, first=True):
    if(first):
      current = self.head
      first = False
    if(current):
      print(current, end = "")
      self.traverse(current.next, first)
    else:
      print() #salto de linea al final

  def deleteHead(self):
    if(self.head != None):
      if(self.head.next != None):
        self.head = self.head.next

  def deleteTail(self):
    if(self.tail != None):
      # Obtener nodo antes de tail (sera el nodo en la posicion self.getSize() -2)
      tailPrev: Node = self.getNodeAt(self.getSize()-2)
      tailPrev.next = None

  def deleteNodeAt(self, index: int):
    if(index == 0):
      self.deleteHead
    if(index == self.getSize()-1):
      self.deleteTail
    else:
      # [A B C]
      # [A C]
      # Obtener A B C
      A = self.getNodeAt(index - 1)
      B = self.getNodeAt(index)
      # El next de A sera el next de B
      A.next = B.next


  def getNodeAt(self, index: int) -> Node:
    current = self.head
    for i in range(index):
      current = current.next
    return current

  def getSize(self):
    counter = 0
    current = self.head
    while(current != None):
      counter += 1
      current = current.next
    return counter
      
  #recibe una lista y agrega uno a uno al final
  def create_from_list(self, value_list):
    for value in value_list:
      self.add(value)
  
  def test1(self):
    prev = None
    current = self.head
    for i in range(self.getSize()):
      if(current.value == "*"):
        # [A  B  C]
        # [A C]
        prev.next = current.next
      prev = current
      current = current.next


  def contarConsonantes(self, nodo: Node):
    vocales = ["a", "e", "i", "o", "u"]
    contador = 0
    string = nodo.value
    for c in string:
      if(not (c in vocales)):
        contador += 1
    return contador

    


  def test2(self):
    nodoMasConsonantes = self.head
    indexNodoMasConstantes = 0

    for i in range(self.getSize()):
      if (self.contarConsonantes(self.getNodeAt(i)) > self.contarConsonantes(nodoMasConsonantes)):

        nodoMasConsonantes = self.getNodeAt(i)
        indexNodoMasConstantes = i


    for j in range(0,indexNodoMasConstantes):
      current = self.getNodeAt(j)
      current.value = (current.value).upper()






print("************ Casos de prueba (Test 1) ************")
caso1 = SinglyLinkedList()
caso1.create_from_list([1,"*",2,6,1,"*",8,2,"*",9,"*",0,1,6,"*",2,15,])
print("Se tiene: ")
caso1.traverse()
print("Se espera: ")
print("1->2->6->1->8->2->9->0->1->6->2->15->")
print("El resultado:")
caso1.test1()
caso1.traverse()




print("************ Casos de prueba (Test 2) ************")
caso2 = SinglyLinkedList()
palabras = ["hola", "hoasdad", "manzana", "naranja", "pera", "platano", "uva", "ciruela", 
            "sandia", "melon", "limon", "lima", "fresa", "arandano", "frambuesa", "kiwi", "piña", 
            "cereza", "mango", "papaya", "durazno", "albaricoque", "pomelo", "pomelo", "aguacate", 
            "mandarina", "granada", "coco", "ciruela", "guayaba", "higo", "zarzamora", "fruta", "vegetal"]

caso2.create_from_list(palabras)
print("Se tiene:")
caso2.traverse()
print("Se espera:")
caso2.test2()
print("La verdad no se que se espera")
caso2.traverse()



