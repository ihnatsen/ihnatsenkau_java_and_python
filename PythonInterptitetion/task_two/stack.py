class Stack:
    def __init__(self):
        self.__collection = list()

    def push(self, item):
        self.__collection.append(item)

    def pop(self):
        return self.__collection.pop()

    def is_empty(self):
        return len(self.__collection) == 0

    def __str__(self):
        return str(self.__collection)
