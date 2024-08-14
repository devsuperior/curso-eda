from binary_search_tree_set import BinarySearchTreeSet

tree = BinarySearchTreeSet([52, 17, 67, 11, 33, 55, 83, 14, 31, 46, 23, 26])

print(tree)

print("\nOriginal:")
print(tree.to_string_format())

tree.add(58)

print("\nAdd test:")
print(tree.to_string_format())

tree.remove(31)

print("\nRemove test:")
print(tree.to_string_format())
