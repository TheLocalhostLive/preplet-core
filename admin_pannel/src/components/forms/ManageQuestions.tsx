import React from "react";
import {
  Box,
  FormControl,
  InputLabel,
  Select,
  MenuItem,
  Button,
  Typography,
  SelectChangeEvent
} from "@mui/material";

const ManageQuestionsForm = () => {
  const [course, setCourse] = React.useState("");
  const [subject, setSubject] = React.useState("");
  const [chapter, setChapter] = React.useState("");

  const handleCourseChange = (event: SelectChangeEvent) => setCourse(event.target.value);
  const handleSubjectChange = (event: SelectChangeEvent) => setSubject(event.target.value);
  const handleChapterChange = (event: SelectChangeEvent) => setChapter(event.target.value);

  return (
    <Box
      sx={{
        width: "100%",
        mx: "auto",
        p: 3,
        bgcolor: "background.paper",
        borderRadius: 2,
        boxShadow: 3,
        color: "text.primary",
      }}
    >
      <Typography variant="h6" gutterBottom>
        Select Course
      </Typography>

      {/* Select Course */}
      <FormControl fullWidth margin="normal" variant="outlined">
        <InputLabel>Select Course</InputLabel>
        <Select value={course} onChange={handleCourseChange} label="Select Course">
          <MenuItem value="">
            <em>None</em>
          </MenuItem>
          <MenuItem value="course1">Course 1</MenuItem>
          <MenuItem value="course2">Course 2</MenuItem>
        </Select>
      </FormControl>

      {/* Select Subject */}
      <FormControl fullWidth margin="normal" variant="outlined">
        <InputLabel>Subject</InputLabel>
        <Select value={subject} onChange={handleSubjectChange} label="Subject">
          <MenuItem value="">
            <em>None</em>
          </MenuItem>
          <MenuItem value="subject1">Subject 1</MenuItem>
          <MenuItem value="subject2">Subject 2</MenuItem>
        </Select>
      </FormControl>

      {/* Select Chapter */}
      <FormControl fullWidth margin="normal" variant="outlined">
        <InputLabel>Chapter</InputLabel>
        <Select value={chapter} onChange={handleChapterChange} label="Chapter">
          <MenuItem value="">
            <em>None</em>
          </MenuItem>
          <MenuItem value="chapter1">Chapter 1</MenuItem>
          <MenuItem value="chapter2">Chapter 2</MenuItem>
        </Select>
      </FormControl>

      {/* Add Questions Button */}
      <Box mt={3}>
        <Button
          fullWidth
          variant="contained"
          color="primary"
          sx={{
            py: 1.5,
            bgcolor: "primary.main",
            borderRadius: 2,
            boxShadow: "0 4px 12px rgba(0,0,0,0.2)",
          }}
        >
          Add Questions
        </Button>
      </Box>
    </Box>
  );
};

export default ManageQuestionsForm;
