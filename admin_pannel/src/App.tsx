import "./App.css";
import { createTheme, ThemeProvider, CssBaseline } from "@mui/material";
import Layout from "./Layout";
import Dummy from "./pages/Dummy";

const darkTheme = createTheme({
  palette: {
    mode: "dark", // Set the theme mode to dark
    primary: {
      main: "#90caf9", // Customize the primary color
    },
    secondary: {
      main: "#f48fb1", // Customize the secondary color
    },
    background: {
      default: "#121212", // Background color for the entire app
      paper: "#1e1e1e", // Background for components like cards, etc.
    },
    text: {
      primary: "#ffffff", // Main text color
      secondary: "#b0bec5", // Secondary text color
    },
  },
});

function App() {
  return (
    <ThemeProvider theme={darkTheme}>
      <CssBaseline />
      <Layout>
        <Dummy />
      </Layout>
    </ThemeProvider>
  );
}

export default App;
