class EmailInfo:
    def __init__(self, username, domain, is_brazilian):
        self.username = username
        self.domain = domain
        self.is_brazilian = is_brazilian


def extract_email_information(email):
    parts = email.split('@')
    username = parts[0]
    domain = parts[1]
    is_brazilian = domain.endswith('.br')
    return EmailInfo(username, domain, is_brazilian)


email_info1 = extract_email_information('joao.silva23@yahoo.com.br')
print(f'Usuario: {email_info1.username}')
print(f'Dominio: {email_info1.domain}')
print(f'Brasileiro: {'sim' if email_info1.is_brazilian else 'nao'}')

email_info2 = extract_email_information('maria123@gmail.com')
print(f'Usuario: {email_info2.username}')
print(f'Dominio: {email_info2.domain}')
print(f'Brasileiro: {'sim' if email_info2.is_brazilian else 'nao'}')
