import pandas
data = {
  "Usernames": ["BBVELU1", "MMPANUG", "PDREDDY"],
  "Passwords": ["password", "CHA16man", "W1indoOO"]
}

dataframe = pandas.DataFrame(data)
print(dataframe)

dataframe.to_csv("Activity17and18CSVData.csv", index=False)