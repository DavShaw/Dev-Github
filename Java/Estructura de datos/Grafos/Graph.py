class Graph:
  def __init__(self):
    self.matrix = []
    self.size = 0

  def print_matrix(self):
    for row in self.matrix:
      print(row)
    print("------")

  def add_vertex(self, tag: str, v=None):
    if(self.size == 0):
      self.matrix.append([0])
    else:
      v_row = [0] * self.size
      self.matrix.append(v_row)
      for row in self.matrix:
        row.append(0)
    self.size += 1
    
  def add_edge(self, v1, v2, directed = False):
    if(v1 >= self.size or v2 >= self.size):
      return "Grave..."

    self.matrix[v1][v2] = 1
    if(not directed):
      self.matrix[v2][v1] = 1




class GraphWeighted:
    def __init__(self):
        self.matrix = []
        self.tags = []
        self.size = 0
        self.non_rep_value = -1

    def tag_exists(self, tag: str):
        return tag in self.tags

    def tag_index(self, tag: str):
        if self.tag_exists(tag):
            return self.tags.index(tag)
        else:
            self.add_vertex(tag)
            return self.size - 1

    def print_matrix(self):
        for row in self.matrix:
            print(row)
        print("------")

    def add_vertex(self, tag: str, v=None):
        self.tags.append(tag)

        if self.size == 0:
            self.matrix.append([self.non_rep_value])
        else:
            v_row = [self.non_rep_value] * self.size
            self.matrix.append(v_row)
            for row in self.matrix:
                row.append(self.non_rep_value)
        self.size += 1

    def delete_vertex(self, tag: str):
        if self.tag_exists(tag):

            index = self.tag_index(tag)

            self.matrix[index] = "ESTA ES LA LISTA" # Quiero borrarla, pero no deja
            #self.matrix.remove(index)
            self.tags.remove(tag)
            self.size -= 1 

            for i in range(index):
               self.matrix[i].remove(index) # Quiero borrar en el indice index

    def add_edge(self, tag1, tag2, weight=5, directed=False):
        v1 = self.tag_index(tag1)
        v2 = self.tag_index(tag2)

        if not directed:
            self.matrix[v2][v1] = weight
        self.matrix[v1][v2] = weight



g = GraphWeighted()
g.add_vertex("a")
g.add_vertex("b")
g.add_vertex("c")
# Bi-directional: a -> b, b -> c;

g.add_edge("a", "b", 5)
g.add_edge("b", "c", 6)
g.print_matrix() 
g.delete_vertex("c")
g.print_matrix()
