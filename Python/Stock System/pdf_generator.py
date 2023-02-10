from functions_admin import TakeFiles
import pdfkit
import jinja2
import datetime
import ctypes
from os import path,remove


def Start_bill_creator(DictToGetInfo):
    time = (datetime.datetime.now())
    #Adding some variables to the dict
    a = f"{time.day}/{time.month}/{time.year} ({time.hour}:{time.minute})"
    from config import config_title,config_company_address,config_company_email

    DictToGetInfo['CurrentDate'] = a
    DictToGetInfo['CompanyName'] = config_title
    DictToGetInfo['BillNumber'] = "FVE - 1"
    DictToGetInfo['CompanyEmail'] = config_company_email
    DictToGetInfo['CompanyAddres'] = config_company_address



    


    if path.exists(TakeFiles('factura.pdf')):
        remove(TakeFiles('factura.pdf'))

    if not (path.exists(TakeFiles('factura.pdf'))):

        template_loader = jinja2.FileSystemLoader(TakeFiles('./'))
        template_env = jinja2.Environment(loader = template_loader)
        template_path = ('bill_template.html')
        template = template_env.get_template(template_path)
        template_text = template.render(DictToGetInfo)


        from config import dev_config_wkhtmltopdf_path


        path_wkhtmltopdf = r"C:/Program Files/wkhtmltopdf/bin/wkhtmltopdf.exe"
        config = pdfkit.configuration(wkhtmltopdf = path_wkhtmltopdf) 
        pdf_name = TakeFiles(f'factura [{time.day}-{time.month}-{time.year}] (H{time.hour} M{time.minute}).pdf')
        pdfkit.from_string(template_text, pdf_name, configuration = config)

