# IST402n8nresumebuilder
Automated AI Resume Generator
This repository contains a workflow and supporting code to automatically generate and improve resumes using n8n, OpenAI, and Google Docs.

Features
Collect user resume data from an HTML form with multi-line support.

Automatically copy a Google Docs resume template and insert user information.

Use OpenAI to rewrite work experience, education, and skills for professionalism and impact.

Seamlessly integrates with Google Drive and the Google Docs API.

Workflow Overview
HTML Form: Collects user resume sections via web form input.

n8n Workflow: Orchestrates the process:

Webhook receives user data.

Edit Fields organizes the data.

OpenAI node rewrites resume content for impact.

Copy file node duplicates the template.

Code node formats the API request and parses AI output.

HTTP node updates the new document with user data.

Respond node returns the finished document link.

Google Docs Integration: Produces a finished, personalized resume document.

Tech Used
JavaScript (n8n Code node for logic and parsing)

HTML (<form> for user input)

OpenAI GPT-3.5/4 (for AI text improvement)

Google Docs API (for document editing)

n8n workflow automation

Setup Instructions
Clone the repository.

Configure your n8n instance and import the workflow.

Update environment variables or credentials as needed for OpenAI and Google APIs.

Serve the HTML form and point the POST action to the n8n webhook endpoint.

Start the workflow and test with sample data.

Notes
For best results, use <textarea> for multi-line input.

Adjust OpenAI temperature and max tokens for creativity and length.

Code node contains robust logic to parse and clean AI output.
