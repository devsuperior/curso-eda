class DateData:
    def __init__(self, day, month, year):
        self.day = day
        self.month = month
        self.year = year


def extract_date_data(date):
    parts = date.split('/')
    day = int(parts[0])
    month = int(parts[1])
    year = int(parts[2])
    return DateData(day, month, year)


obj = extract_date_data("21/07/2010")
print(f"Dia: {obj.day}")
print(f"Mês: {obj.month}")
print(f"Ano: {obj.year}")
