const formData = $('Edit Fields').item.json;
const documentId = $('Copy file').item.json.id;

let aiResponse;
try {
  let content = $('OpenAI').first().json.message.content;
  
  content = content.trim();
  aiResponse = JSON.parse(content);
  
  if (!aiResponse.workExperience || !aiResponse.education || !aiResponse.skills) {
    throw new Error('Missing AI keys');
  }
} catch (e) {
  console.log('AI parsing failed or keys missing:', e);
  aiResponse = {
    workExperience: formData.workExperience,
    education: formData.education,
    skills: formData.skills
  };
}

const workExp = typeof aiResponse.workExperience === 'string' && aiResponse.workExperience.trim()
  ? aiResponse.workExperience
  : (formData.workExperience || "Not provided");
  
const edu = typeof aiResponse.education === 'string' && aiResponse.education.trim()
  ? aiResponse.education
  : (formData.education || "Not provided");
  
const skills = typeof aiResponse.skills === 'string' && aiResponse.skills.trim()
  ? aiResponse.skills
  : (formData.skills || "Not provided");

return {
  json: {
    documentId: documentId,
    requests: [
      {
        replaceAllText: {
          containsText: { text: "FULLNAME", matchCase: true },
          replaceText: formData.fullName || "Not provided"
        }
      },
      {
        replaceAllText: {
          containsText: { text: "EMAIL", matchCase: true },
          replaceText: formData.email || "Not provided"
        }
      },
      {
        replaceAllText: {
          containsText: { text: "PHONE", matchCase: true },
          replaceText: formData.phone || "Not provided"
        }
      },
      {
        replaceAllText: {
          containsText: { text: "ADDRESS", matchCase: true },
          replaceText: formData.address || "Not provided"
        }
      },
      {
        replaceAllText: {
          containsText: { text: "WORKEXPERIENCE", matchCase: true },
          replaceText: String(workExp)
        }
      },
      {
        replaceAllText: {
          containsText: { text: "EDUCATION", matchCase: true },
          replaceText: String(edu)
        }
      },
      {
        replaceAllText: {
          containsText: { text: "SKILLS", matchCase: true },
          replaceText: String(skills)
        }
      }
    ]
  }
};
