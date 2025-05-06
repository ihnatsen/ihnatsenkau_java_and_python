import unittest
from task_one.main import is_num_array, find_all_multiples_of_3, is_greater_than_7


class TestTaskOne(unittest.TestCase):
    def test_is_num_array(self):
        self.assertFalse(is_num_array('[]'))
        self.assertFalse(is_num_array('[][]'))
        self.assertFalse(is_num_array('[not is digit]'))
        self.assertFalse(is_num_array('[not is digit, 4]'))
        self.assertTrue(is_num_array('[1, 2, 3, 4]'))
        self.assertTrue(is_num_array('[0, 1, 2, 3, 4]'))
        self.assertTrue(is_num_array('[0, -1, 2, -3, -4]'))
        self.assertTrue(is_num_array('[0.0, -1.0, 2, -3.0, -4.1]'))

    def test_find_all_multiples_of_3(self):
        self.assertEqual(find_all_multiples_of_3('[3]'), [3.0])
        self.assertEqual(find_all_multiples_of_3('[-3]'), [-3.0])
        self.assertEqual(find_all_multiples_of_3('[-3, 0.0]'), [-3.0, 0.0])
        self.assertEqual(find_all_multiples_of_3('[3.0, 0.0]'), [3.0, 0.0])
        self.assertEqual(find_all_multiples_of_3('[3, 4, 6, 7, 9, 10]'), [3.0, 6.0, 9.0])

    def test_is_greater_than_7(self):
        self.assertFalse(is_greater_than_7('-7'))
        self.assertFalse(is_greater_than_7('0'))
        self.assertFalse(is_greater_than_7('7'))
        self.assertTrue(is_greater_than_7('10'))

        self.assertFalse(is_greater_than_7('-7.0'))
        self.assertFalse(is_greater_than_7('0.0'))
        self.assertFalse(is_greater_than_7('7.0'))
        self.assertTrue(is_greater_than_7('10.0'))


