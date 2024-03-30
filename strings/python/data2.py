def format_date(day, month, year):
    format_day = f"{day:02d}"
    format_month = f"{month:02d}"

    return f"{format_day}/{format_month}/{year}"


print(format_date(21, 7, 2010))
