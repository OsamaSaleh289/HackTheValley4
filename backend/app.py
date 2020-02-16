# app.py
from flask import Flask, request, jsonify
import pymongo
from pymongo import MongoClient
import math

app = Flask(__name__)
cluster = MongoClient("mongodb+srv://OsamaSaleh:Apple_1234@cluster0-a2ddf.mongodb.net/test?retryWrites=true&w=majority")
database = cluster["Data"]
collection = database["Data"]

# In meters
EARTH_RADIUS = 6371.0088
DIST_THRESHOLD = 200

# URL/post?time="_"&user="_"&lat="_"&lon="_"&content="_"
@app.route('/post', methods=['GET','POST'])
def make_post():
    time = request.args.get("time", None)
    user = request.args.get("user", None)
    lat = request.args.get("lat", None)
    lon = request.args.get("lon", None)
    content = request.args.get("content", None)

    #POST IMPLEMENTATION HERE
    post(userId=user, msg=content.replace('+', ' '), lat=float(lat), lng=float(lon), time=time)

    #if (time is None | user is None | lat is None | lon is None | content is None):
    #    return jsonify({"Payload":[], "Error": "Query missing"})

    return jsonify({"Payload":[], "Error": "None"})

# URL/update?user="_"&lat="_"&lon="_"
@app.route('/update', methods=['GET','POST'])
def update_post():
    #print("Start UPDATE")

    user = request.args.get("user", None)
    lat = request.args.get("lat", None)
    lon = request.args.get("lon", None)

    #print("FINISHED PARSING")

    #UPDATE IMPLEMENTATION HERE
    update(user, float(lat), float(lon))

    return jsonify({})

# URL/get?user="_"&lat="_"&lon="_"
@app.route('/get', methods=['GET'])
def get_post():
    user = request.args.get("user", None)
    lat = request.args.get("lat", None)
    lon = request.args.get("lon", None)

    #GET IMPLEMENTATION HERE
    unsorted_posts = receive()
    sorted_posts = []

    for post in unsorted_posts:
        
        if within_dist(a_lat=float(post['lat']), a_lon=float(post['lng']), b_lat=float(lat), b_lon=float(lon)) == True:
            sorted_posts.append(post)

    return jsonify(sorted_posts)


# A welcome message to test our server
@app.route('/')
def index():
    return "<h1>Hello World</h1>"

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

def update(userId, lat, lng):
    collection.update_one({"_id": userId},
                          {"$set": {"lat": lat,
                                    "lng": lng}})

def receive():
    returnValues = []
    myquery = {"_id": {"$regex": ".*"}}
    mydoc = collection.find(myquery)


    for item in mydoc:
        #print(item)
        #print(type(item))
        returnValues.append(item)

    #print(len(returnValues))
    return returnValues


def within_dist(a_lat, a_lon, b_lat, b_lon):
    dLat = b_lat * math.pi / 180 - a_lat * math.pi / 180
    dLon = b_lon * math.pi / 180 - a_lon * math.pi / 180
    a = math.sin(dLat/2) * math.sin(dLat/2) + math.cos(a_lat * math.pi / 180) * math.cos(b_lat * math.pi / 180) * math.sin(dLon/2) * math.sin(dLon/2)
    c = 2 * math.atan2(math.sqrt(a), math.sqrt(1-a))
    d = EARTH_RADIUS * c

    meters = d * 1000
    meters = round(meters,0)
    #print(meters)
    return meters < DIST_THRESHOLD

if __name__ == '__main__':
    # Threaded option to enable multiple instances for multiple user access support
    app.run(threaded=True, port=5000)