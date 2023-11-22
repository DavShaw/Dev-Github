from dataclasses import dataclass, field
from typing import Optional
from src.models.Graph.Types import *

@dataclass
class Node:
    value: Optional[str] = None

    def __hash__(self):
        return hash(self.value)
    def __repr__(self) -> str:
        return str(self.value)

@dataclass
class Edge:
    from_node: Node = field(default_factory=Node)
    to_node: Node = field(default_factory=Node)
    type: NodeTypes = field(default_factory=NodeTypes)

    def __repr__(self) -> str:
        return f"{self.from_node} ({self.type.get_type()}) -> {self.to_node}"
    
    def __hash__(self) -> int:
        return hash((self.from_node, self.to_node, self.type))


