class Car:
    #constructor below
    def __init__(self, makeInput, modelInput):
        self.make = makeInput
        self.model = modelInput
        self.mileage = 0
        
    def drive(self):
        self.mileage += 10


car1 = Car("Toyota", "Rav-4")
car2 = Car("Honda", "Accord")
car3 = Car("Tesla", "Model X")


print(car1.mileage)
print(car2.mileage)
print(car3.mileage)

print(car1.make)
print(car2.make)
print(car3.make)
car1.drive()
print(car1.mileage)
print(car2.mileage)






