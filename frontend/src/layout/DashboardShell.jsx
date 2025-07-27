import { AppShell, Navbar, Header, NavLink, ScrollArea } from '@mantine/core';
import { Outlet, Link } from 'react-router-dom';

export default function DashboardShell() {
  return (
    <AppShell
      padding="md"
      navbar={
        <Navbar width={{ base: 250 }} p="xs">
          <Navbar.Section grow component={ScrollArea}>
            <NavLink label="Dashboard" component={Link} to="/" />
            <NavLink label="Earthquakes" component={Link} to="/earthquakes" />
            <NavLink label="Weather" component={Link} to="/weather" />
            <NavLink label="Epidemics" component={Link} to="/epidemics" />
            <NavLink label="Social Trends" component={Link} to="/social-trends" />
            <NavLink label="Financial" component={Link} to="/financial" />
          </Navbar.Section>
        </Navbar>
      }
      header={
        <Header height={60} p="xs">
          <h1>Anomalia Dashboard</h1>
        </Header>
      }
    >
      <Outlet />
    </AppShell>
  );
}
