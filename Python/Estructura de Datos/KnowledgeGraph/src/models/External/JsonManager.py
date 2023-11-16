import json
import os

class JsonGenerator:
    def __init__(self):
        pass

    def generate_json(self, data, filename='output.json'):
        try:
            counter = 1
            base_filename, file_extension = os.path.splitext(filename)
            new_filename = filename

            while os.path.exists(new_filename):
                counter += 1
                new_filename = f"{base_filename}No{counter}{file_extension}"

            with open(new_filename, 'w', encoding = 'utf-8') as json_file:
                json.dump(data, json_file, indent = 2, ensure_ascii=False)

            print(f'JSON generated successfully: {new_filename}')
        except Exception as e:
            print(f'JSON cannot be generated successfully: {e}')

    def generate_dictionary(self, filename):
        try:
            with open(filename, 'r', encoding='utf-8') as json_file:
                data = json.load(json_file)
            return data
        except Exception as e:
            print(f'Error reading JSON file: {e}')
            return None