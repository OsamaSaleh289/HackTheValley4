# app.py
from flask import Flask, request, jsonify
app = Flask(__name__)

@app.route('/post', methods=['POST'])
def respond():
    time = request.args.get("time", None)
    user = request.args.get("user", None)
    lat = request.args.get("lat", None)
    lon = request.args.get("lon", None)
    content = request.args.get("content", None)

    #POST IMPLEMENTATION HERE


    return jsonify(response)

@app.route('/update', methods=['POST'])
def post_something():
    user = request.args.get("user", None)
    lat = request.args.get("lat", None)
    lon = request.args.get("lon", None)

    #UPDATE IMPLEMENTATION HERE


@app.route('/get', methods=['GET'])
def post_something():
    user = request.args.get("user", None)
    lat = request.args.get("lat", None)
    lon = request.args.get("lon", None)

    #GET IMPLEMENTATION HERE

# A welcome message to test our server
@app.route('/')
def index():
    return "<h1>Hello World</h1>"

if __name__ == '__main__':
    # Threaded option to enable multiple instances for multiple user access support
    app.run(threaded=True, port=5000)