import re

number_pattern = re.compile(r'-?\d+(?:\.\d+)?')
array_pattern = re.compile(r'^\[\s*-?\d+(\.\d+)?(\s*,\s*-?\d+(\.\d+)?)*\s*\]$')


def is_num_array(input_data: str) -> bool:
    return bool(re.search(array_pattern, input_data))


def find_all_multiples_of_3(input_data: str) -> list[float]:
    numbers = re.findall(number_pattern, input_data)
    return list(filter(lambda n: n % 3 == 0, map(float, numbers)))


def is_greater_than_7(data: str) -> bool:
    if re.match(number_pattern, data):
        return float(data) > 7
    return False


def run():
    print("Please enter data for the program.")
    print("To input an array, use the format: [<value1>, <value2>, ...]")
    print("For example: [1, 2, 3]\n")
    data = input("Enter data: ")

    match data:
        case 'John':
            print('Hello, John')
        case _ if is_num_array(data):
            print(f'The array contains multiples of 3:')
            print(find_all_multiples_of_3(data))
        case _ if is_greater_than_7(data):
            print("Hello")


if __name__ == '__main__':
    run()
