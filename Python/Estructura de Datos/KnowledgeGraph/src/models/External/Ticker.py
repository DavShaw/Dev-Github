import time

class Ticker:
    def __init__(self):
        self._start_time = None
        self._end_time = None
        self._result = None

    def start(self):
        self._start_time = time.time()

    def stop(self):
        self._end_time = time.time()

    def _calculate_result(self):
        if self._start_time is None:
            raise ValueError("You might need to call start method before calculating the result.")
        if self._end_time is None:
            raise ValueError("You might need to call stop method before calculating the result.")
        self._result = self._end_time - self._start_time
    
    def show_result(self) -> None:
        self._calculate_result()
        print(f"Elapsed time: {self._result} seconds.")
