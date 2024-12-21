import InboxIcon from "@mui/icons-material/MoveToInbox";
import List from "@mui/material/List";
import ListItem from "@mui/material/ListItem";
import ListItemButton from "@mui/material/ListItemButton";
import ListItemIcon from "@mui/material/ListItemIcon";
import ListItemText from "@mui/material/ListItemText";
import MailIcon from "@mui/icons-material/Mail";
import Toolbar from "@mui/material/Toolbar";
import {
  DASHBOARD_PATH,
  MANAGE_USERS_PATH,
  MANAGE_COURSES_PATH,
  MANAGE_SUBJECT_TOPICS_PATH,
  MANAGE_QUESTIONS_ANSWERS,
} from "../constants";
import { Link } from "react-router";

function Sidebar() {
  const routes = [
    {
      text: "Dashboard",
      path: DASHBOARD_PATH,
    },
    {
      text: "Manage Users",
      path: MANAGE_USERS_PATH,
    },
    {
      text: "Manage Courses",
      path: MANAGE_COURSES_PATH,
    },
    {
      text: "Manage Subject & topics",
      path: MANAGE_SUBJECT_TOPICS_PATH,
    },
    {
      text: "Manage Questions & Answers",
      path: MANAGE_QUESTIONS_ANSWERS,
    },
  ];
  return (
    <div>
      <Toolbar />
      <List>
        {routes.map(({ text, path }, index) => (
          <Link style={{color: "white", textDecoration: "none"}} key={path} to={path}>
            <ListItem key={text} disablePadding>
              <ListItemButton>
                <ListItemIcon>
                  {index % 2 === 0 ? <InboxIcon /> : <MailIcon />}
                </ListItemIcon>
                <ListItemText primary={text} />
              </ListItemButton>
            </ListItem>
          </Link>
        ))}
      </List>
    </div>
  );
}

export default Sidebar;
