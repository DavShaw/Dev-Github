from typing import Any
from Exceptions import StackOverflow
from Exceptions import StackUnderflow


class Stack:

    def __init__(self, length) -> None:
        self.__list = [None] * length
        self.__length = length
        self.__totalElements = 0
    
    def push(self, element):
        if self.__totalElements != self.__length:
            self.__list[self.__totalElements] = element
            self.__totalElements += 1
        else:
            raise StackOverflow("Stack Overflow")
        
    def pop(self):
        if self.__totalElements != 0:
            self.__totalElements -= 1
            supportVariable = self.__list[self.__totalElements]
            self.__list[self.__totalElements] = None
            return supportVariable
        else:
            raise StackUnderflow("Stack Underflow")
        
    def top(self):
        if self.__totalElements == 0:
            raise StackUnderflow("Stack Underflow")
        else:
            return self.__list[self.__totalElements - 1]
    def getLenth(self):
        return self.__length
        
    def __repr__(self) -> str:
        return str(self.__list)