import pymongo
from pymongo import MongoClient


#Update by new post
def post(userId, msg, lat, lng, time):
    new = False
    #Check if the current user is new
    results = collection.find_one({"_id":userId})
    if(results is None):
        new = True
    updatedPost = {"_id": userId, "msg": msg, "time": time, "lat": lat,
                   "lng": lng}
    #Insert new user
    if(new):
        collection.insert_one(document=updatedPost)

    #Update existing user
    else:
        collection.update_one({"_id" : userId},
                              {"$set":{"msg":updatedPost["msg"],
                                       "time":updatedPost["time"],
                                       "lat":updatedPost["lat"],
                                       "lng":updatedPost["lng"]}})


def recieve():
    returnValues = []
    myquery = {"_id": {"$regex": ".*"}}
    mydoc = collection.find(myquery)


    for item in mydoc:
        returnValues.append(item)

    print(len(returnValues))
    return returnValues



#Update user loction frequently
def update(userId, lat, lng):
    collection.update_one({"_id": userId},
                          {"$set": {"lat": lat,
                                    "lng": lng}})

### TESTING SUITE

'''def postTest():
    post("Osama", "Feeling happy", "100.0", "200.0", "30")
    post("Martin", "Feeling sad", "50.0", "75.0", "25")
    post("Talal", "Feeling anxious", "30.0", "75.0", "25.0")
    update("Talal","0.0","0.0")
    post("Martin", "Feeling anxious", "20.0", "75.0", "25.0")

def recieveTest():
    recieve()'''

cluster = MongoClient("mongodb+srv://OsamaSaleh:Apple_1234@cluster0-a2ddf.mongodb.net/test?retryWrites=true&w=majority")
database = cluster["Data"]
collection = database["Data"]


