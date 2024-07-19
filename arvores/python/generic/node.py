class Node:
    def __init__(self, element, parent=None):
        self.__element = element
        self.__parent = parent
        self.__children = []

    def element(self):
        return self.__element

    def _set_element(self, element):
        self.__element = element

    def _get_parent(self):
        return self.__parent

    def _set_parent(self, parent):
        self.__parent = parent

    def _get_children(self):
        return self.__children

    def _add_child(self, child):
        self.__children.append(child)
        child._set_parent(self)

    def _remove_child(self, child):
        self.__children.remove(child)
        child._set_parent(None)

    def _is_leaf(self):
        return len(self.__children) == 0
