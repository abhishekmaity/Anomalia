import React from 'react';
import { Group, Text, Box } from '@mantine/core';

export default function CustomHeader() {
  return (
    <Box px="md" py="xs" style={{ backgroundColor: '#f5f5f5' }}>
      <Group position="apart">
        <Text size="xl" weight={700}>
          🌐 Anomalia Dashboard
        </Text>
      </Group>
    </Box>
  );
}
