require('dotenv').config();

const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const MongoClient = require('mongodb').MongoClient;
const dotenv = require('dotenv');
dotenv.config();

const port = process.env.PORT || 8080;
const mongoURI = process.env.MONGO_URI;

// Middleware to parse incoming JSON data
app.use(bodyParser.json());

// Connect to MongoDB
MongoClient.connect(mongoURI, { useNewUrlParser: true, useUnifiedTopology: true })
  .then((client) => {
    const db = client.db('incident_db');
    const incidentsCollection = db.collection('incidents');

    // API endpoint to handle incident data submission
    app.post('/api/incidents', (req, res) => {
      const incidentData = req.body;

      // Insert the incident data into the MongoDB collection
      incidentsCollection.insertOne(incidentData)
        .then(() => {
          res.status(201).json({ message: 'Incident data saved successfully' });
        })
        .catch((error) => {
          res.status(500).json({ error: 'Failed to save incident data' });
        });
    });

    // Start the server
    app.listen(port, () => {
      console.log(`Backend server started on http://localhost:${port}`);
    });
  })
  .catch((error) => {
    console.error('Error connecting to MongoDB:', error);
  });
