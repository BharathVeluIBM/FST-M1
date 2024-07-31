import pandas as pd

data = {
    'FirstName': ["Bharath", "Ramya", "Ezhilan"],
    'LastName': ["Velu", "Vaithi", "Bharath"],
    'Email': ["svt.bharath@gmail.com", "Ramyavaithi@gmail.com", "ezhilan.bharath@gmail.com"],
    'PhoneNumber': ["9789769694", "9789764434", "9789764435"]
}

dataframe = pd.DataFrame(data)

print(dataframe)

with pd.ExcelWriter('Activity19ExcelData.xlsx', engine='openpyxl') as writer:
    dataframe.to_excel(writer, sheet_name='Sheet1', index=False)
