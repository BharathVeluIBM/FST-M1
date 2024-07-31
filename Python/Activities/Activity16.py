class Car:
    'This class represents a car'

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " has started." 
              +  ". It was made in "+ self.make + " and its color was " + self.color + ".")

    def stop(self):        
        print(self.manufacturer + " " + self.model + " has stopped." 
              +  ". It was made in "+ self.make + " and its color was " + self.color + ".")

car1 = Car("Toyota", "Tata", "2015", "Manual", "White")
car2 = Car("Maruti", "800", "2013", "Manual", "Red")
car3 = Car("Suzuki", "Swift", "2017", "Automatic", "Black")

car2.accelerate()
car3.stop()