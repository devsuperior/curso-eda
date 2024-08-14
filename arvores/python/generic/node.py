class Node:
    def __init__(self, element, parent=None):
        self._element = element
        self._parent = parent
        self._children = []

    def element(self):
        return self._element

    def _set_element(self, element):
        self._element = element

    def _get_parent(self):
        return self._parent

    def _set_parent(self, parent):
        self._parent = parent

    def _get_children(self):
        return self._children

    def _add_child(self, child):
        self._children.append(child)
        child._set_parent(self)

    def _remove_child(self, child):
        self._children = [c for c in self._children if c != child]
        child._set_parent(None)

    def _is_leaf(self):
        return len(self._children) == 0
