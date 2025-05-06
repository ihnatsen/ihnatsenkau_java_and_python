from task_two.stack import Stack
import re


def is_braces_sequence_correct(braces_sequence):
    braces = {')': '(', ']': '['}
    stack = Stack()
    for brace in braces_sequence:
        if brace in "([":
            stack.push(brace)
        elif stack.is_empty():
            return False
        elif braces[brace] != stack.pop():
            return False
    return stack.is_empty()


def get_invalid_brace_indices(sequence):
    sequence = list(sequence)
    braces = {')': '(', ']': '['}
    stack = Stack()
    to_remove = set()

    for index, char in enumerate(sequence):
        if char in "([":
            stack.push((char, index))
        elif char in ")]":
            if stack.is_empty():
                to_remove.add(index)
            else:
                open_char, open_index = stack.pop()
                if braces[char] != open_char:
                    to_remove.add(index)
                    to_remove.add(open_index)

    while not stack.is_empty():
        _, index = stack.pop()
        to_remove.add(index)

    return [item + 1 for item in to_remove]


def run(sequence):
    is_ok = is_braces_sequence_correct(sequence)
    print(f'The sequence: {sequence} '
          f'can{'' if is_ok else 'not'} '
          f'considered correct.')
    if not is_ok:
        print(f'Need to delete brace: {get_invalid_brace_indices(sequence)}')


if __name__ == '__main__':
    the_sequence = '[((())()(())]]'
    run(the_sequence)
    print()

    while True:
        command = input('Do you want to continue? [y/n] ')
        match command:
            case 'y':
                sequence = input("Enter a sequence: ")
                if re.fullmatch(r"[()\[\]]*", sequence):
                    run(sequence)
                else:
                    print('Invalid input')
            case 'n':
                break
            case _:
                print('Invalid input')
