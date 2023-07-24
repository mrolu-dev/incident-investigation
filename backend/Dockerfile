# Use the official Node.js image as the base image
FROM node:14

# Set the working directory inside the container
WORKDIR /app

# Copy the package.json and package-lock.json to the working directory
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the backend files to the working directory
COPY server.js ./

# Expose the port on which the backend will run
EXPOSE 8085

# Command to start the backend server
CMD ["node", "server.js"]
