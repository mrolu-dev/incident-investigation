# Use the official Nginx image as the base image
FROM nginx:1.23.3

# Remove the default Nginx configuration file
RUN rm /etc/nginx/conf.d/default.conf

# Copy your custom Nginx configuration file
COPY default.conf /etc/nginx/conf.d/default.conf

# Copy the index.html and script.js to the Nginx web root directory
COPY *webapp /usr/share/nginx/html

# Expose the Nginx port
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
