def calculate_sum(numbers):
    total = 0
    for number in numbers:
        total += number
    return total

def get_user_list():
    user_input = input("Enter numbers separated by spaces: ")
    number_strings = user_input.split()
    numbers = [int(num) for num in number_strings]
    
    return numbers

if __name__ == "__main__":
    user_list = get_user_list()
    total_sum = calculate_sum(user_list)
    print(f"The sum of all the elements in the list is: {total_sum}")
