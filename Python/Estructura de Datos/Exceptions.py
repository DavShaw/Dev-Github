class StackOverflow(Exception):

    def __init__(self, *args: object) -> None:
        super().__init__(*args)

class StackUnderflow(Exception):

    def __init__(self, *args: object) -> None:
        super().__init__(*args)