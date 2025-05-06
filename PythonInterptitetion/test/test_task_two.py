import unittest
from task_two.main import *
from task_two.stack import *


class TestTaskTwo(unittest.TestCase):

    def test_stack(self):
        stack = Stack()
        stack.push(1)
        self.assertFalse(stack.is_empty())
        self.assertEqual(stack.pop(), 1)
        self.assertTrue(stack.is_empty())

    def test_is_braces_sequence_correct(self):
        self.assertTrue(is_braces_sequence_correct(''))
        self.assertTrue(is_braces_sequence_correct('[]'))
        self.assertTrue(is_braces_sequence_correct('[]()'))
        self.assertTrue(is_braces_sequence_correct('[()]'))
        self.assertTrue(is_braces_sequence_correct('([()])'))
        self.assertFalse(is_braces_sequence_correct('('))
        self.assertFalse(is_braces_sequence_correct(')'))
        self.assertFalse(is_braces_sequence_correct('['))
        self.assertFalse(is_braces_sequence_correct(']'))
        self.assertFalse(is_braces_sequence_correct('[(]'))
        self.assertFalse(is_braces_sequence_correct('[)]'))
        self.assertFalse(is_braces_sequence_correct('([)'))
        self.assertFalse(is_braces_sequence_correct('(])'))
        self.assertFalse(is_braces_sequence_correct('[[(]]'))
        self.assertFalse(is_braces_sequence_correct('[([)]]'))

    def test_get_invalid_brace_indices(self):
        self.assertEqual(get_invalid_brace_indices(''), [])
        self.assertEqual(get_invalid_brace_indices(')'), [1])
        self.assertEqual(get_invalid_brace_indices(']'), [1])
        self.assertEqual(get_invalid_brace_indices('['), [1])
        self.assertEqual(get_invalid_brace_indices('[()]]'), [5])
        self.assertEqual(get_invalid_brace_indices(')[()]]'), [1, 6])
        self.assertEqual(get_invalid_brace_indices('[()][[[[['), [5, 6, 7, 8, 9])
        self.assertEqual(get_invalid_brace_indices('[(])'), [1, 2, 3, 4])
