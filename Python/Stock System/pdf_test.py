from functions_admin import TakeFiles
import pdfkit
import jinja2
import datetime
import ctypes
from os import path,remove

def GenerateDict():
    TSend = {}
    TSend['ClientName'] = ClientName
    TSend['CompanyName'] = CompanyName
    TSend['SellerName'] = SellerName
    TSend['TimeFecha'] = TimeFecha
    TSend['TimeHora'] = TimeHora
    TSend['CompanyAddres'] = CompanyAddres
    TSend['CompanyEmail'] =  CompanyEmail
    TSend['TotalToPay'] = TotalToPay
    TSend['BillNumber'] = BillNumber
    TSend['GeneralProductInfo'] = GeneralProductInfo
    #TSend['AllProductName'] = AllProductName
    #TSend['AllProductRef'] = AllProductRef
    #TSend['AllProductPrice'] = AllProductPrice

    return TSend

time = (datetime.datetime.now())

ClientName = "Alfonso Manuel"
CompanyName = "David's Coffee"
SellerName = "David Torres"
TimeFecha = (f"{time.day}/{time.month}/{time.year}")
TimeHora = (f"{time.hour}:{time.minute}")
CompanyAddres = "Calle 3 #52-15"
CompanyEmail = "contact@davidscoffee.com.co"
TotalToPay = "5000"
BillNumber = "FV525"
GeneralProductInfo = "| Café Japonés | x5 | 800 | CJ-5 |"
GeneralProductInfo += "\n"
GeneralProductInfo += "| Café Colombiano | x2 | 1500 | CJ-11 |"
GeneralProductInfo += "\n"
GeneralProductInfo += "| Café Américano | x3 | 1000 | CJ-2 |"
AllProductName = ""
AllProductRef = "CF-JP\nhh"
AllProductPrice = "12000\n89252"
VariablesToBill = GenerateDict()





if path.exists(TakeFiles('factura.pdf')):
    remove(TakeFiles('factura.pdf'))

if not (path.exists(TakeFiles('factura.pdf'))):

    template_loader = jinja2.FileSystemLoader(TakeFiles('./'))
    template_env = jinja2.Environment(loader = template_loader)
    template_path = ('bill_template.html')
    template = template_env.get_template(template_path)
    template_text = template.render(VariablesToBill)

    path_wkhtmltopdf = r'C:\\Program Files\\wkhtmltopdf\\bin\\wkhtmltopdf.exe'
    config = pdfkit.configuration(wkhtmltopdf = path_wkhtmltopdf) 
    pdf_name = TakeFiles('factura.pdf')
    pdfkit.from_string(template_text, pdf_name, configuration = config)

